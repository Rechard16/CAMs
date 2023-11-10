/*
 * package model;
 * 
 * import java.time.LocalDateTime;
 * import java.time.format.DateTimeFormatter;
 * 
 * public class Change {
 * private static int lastChangeId = 0; // 用于生成唯一的changeId
 * private int changeId;
 * private int queryId;
 * private String description;
 * private LocalDateTime timestamp;
 * 
 * public Change(int queryId, String description) {
 * this.changeId = ++lastChangeId; // 生成下一个唯一的ID
 * this.queryId = queryId;
 * this.description = description;
 * this.timestamp = LocalDateTime.now(); // 设置当前时间为timestamp
 * }
 * 
 * public int getChangeId() {
 * return changeId;
 * }
 * 
 * public int getQueryId() {
 * return queryId;
 * }
 * 
 * public String getDescription() {
 * return description;
 * }
 * 
 * public LocalDateTime getTimestamp() {
 * return timestamp;
 * }
 * 
 * public String toString() {
 * return "Change ID: " + this.changeId +
 * ", Query ID: " + this.queryId +
 * ", Description: " + this.description +
 * ", Timestamp: " +
 * this.timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
 * }
 * 
 * // 如果需要，可以添加setter方法
 * }
 */
package model;

public interface Change {
    public void modify();
}