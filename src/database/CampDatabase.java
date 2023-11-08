package database;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import model.Camp;

// 导入必要的类

public class CampDatabase extends Database<Camp> {

    private final String filename = "../data/camps"; // 例如使用YAML格式存储
    private List<Camp> camps;

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public List<Camp> getAll() {
        // 从文件加载所有Camp对象
        File file = new File(getFilename());
        if (file.exists()) {
            camps = MapperCollection.load(getFilename(), new TypeReference<List<Camp>>() {
            });
        }
        return camps;
    }

    @Override
    public void setAll(List<Camp> objectList) {
        // 将提供的Camp对象列表保存到文件
        this.camps = objectList;
        MapperCollection.save(camps, getFilename());
    }

}
