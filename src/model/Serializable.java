package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Serializable {

    public static String serialize(List<Serializable> listOfModel) {
        StringBuilder serializedString = new StringBuilder();
        for (Serializable model : listOfModel) {
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    serializedString.append(field.get(model).toString()).append("$");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            if (serializedString.length() > 0 && serializedString.charAt(serializedString.length() - 1) == '$') {
                serializedString.deleteCharAt(serializedString.length() - 1);
                serializedString.append("*");
            }
            if (serializedString.length() > 0 && serializedString.charAt(serializedString.length() - 1) == '*') {
                serializedString.deleteCharAt(serializedString.length() - 1);
            }
        }
        return serializedString.toString();
    }

        public static <T extends Serializable> List<T> deserialize(String serializedData, Class<T> cls) {
            List<T> deserializedList = new ArrayList<>();


            String[] objectStrings = serializedData.split("\\*");

            for (String objectString : objectStrings) {

                if (objectString.isEmpty()) {
                    continue;
                }


                String[] fieldValues = objectString.split("\\$");
                try {
                    T objectInstance = cls.getDeclaredConstructor().newInstance();

                    Field[] fields = cls.getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        field.setAccessible(true);
                        if (i < fieldValues.length) {
                            String stringValue = fieldValues[i];
                            Object value = stringValue;

                            Class<?> type = field.getType();
                            if (type == int.class || type == Integer.class) {
                                value = Integer.parseInt(stringValue);
                            } else if (type == double.class || type == Double.class) {
                                value = Double.parseDouble(stringValue);
                            } else if (type == float.class || type == Float.class) {
                                value = Float.parseFloat(stringValue);
                            } else if (type == long.class || type == Long.class) {
                                value = Long.parseLong(stringValue);
                            } else if (type == boolean.class || type == Boolean.class) {
                                value = Boolean.parseBoolean(stringValue);
                            } else if (type == byte.class || type == Byte.class) {
                                value = Byte.parseByte(stringValue);
                            } else if (type == short.class || type == Short.class) {
                                value = Short.parseShort(stringValue);
                            } else if (type == char.class || type == Character.class) {
                                value = stringValue.charAt(0);
                            } else if (type.isEnum()) {

                                Class<? extends Enum> enumType = (Class<? extends Enum>)type;
                                value = Enum.valueOf(enumType, stringValue);
                            }


                            try {
                                field.set(objectInstance, value);
                            } catch (IllegalAccessException e) {
                                System.out.println("Cannot set value for field " + field.getName() + " of class " + cls.getName() + "value: " + value + "\n");
                                e.printStackTrace();
                            }
                        }
                    }

                    deserializedList.add(objectInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return deserializedList;
        }

}
