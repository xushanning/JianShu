package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 许 on 2020/11/8.
 */

class CollectData {
    private static CollectData singleInstance = null;
    private List<int[][]> allData = null;

    private CollectData() {
        allData = new ArrayList<>();
    }

    public static CollectData getInstance() {
        if (singleInstance == null) {
            singleInstance = new CollectData();
        }
        return singleInstance;
    }

    public void add(int[][] data) {
        allData.add(data);
    }

    public List<int[][]> getAllData() {
        return allData;
    }
}
