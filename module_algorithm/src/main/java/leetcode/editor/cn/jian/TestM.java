package leetcode.editor.cn.jian;

/**
 * @author 许
 * 36进制，字节跳动面试题，挂掉了
 */

class TestM {


    public void getString() {

    }

    public String addFunWithStr(String param1, String param2) {

        StringBuffer stringBuffer = new StringBuffer();
        String symbol = "0123456789abcdefghijklmnopqrstuvwxyz";
        int param1Len = param1.length();
        int param2Len = param2.length();

        int i = param1Len - 1;
        int j = param2Len - 1;

        if (i < 0 || j < 0) {
            return null;
        }


        int temp = 0;

        while (i >= 0 && j >= 0) {

            char ch_1 = param1.charAt(i);
            char ch_2 = param2.charAt(j);

            int v1 = getIntFromChar(ch_1);
            int v2 = getIntFromChar(ch_2);

            int ret = v1 + v2;

            if (ret >= 36) {
                int index = ret - 36 + temp;
                char sv = symbol.charAt(index);
                stringBuffer.append(sv);
                temp = 1; //进位
            } else {
                int index = ret + temp;
                char sv = symbol.charAt(index);
                stringBuffer.append(sv);
                temp = 0;
            }

            i--;
            j--;

        }

        while (i >= 0) {

            char ch_1 = param1.charAt(i);
            stringBuffer.append(ch_1);

            i--;
        }

        while (j >= 0) {
            char ch_2 = param2.charAt(i);
            stringBuffer.append(ch_2);
            j--;
        }

        StringBuffer result = stringBuffer.reverse();

        return result.toString();

    }

    public int getIntFromChar(char ch) {

        int ret = -1;

        if (ch >= '0' && ch <= '9') {
            ret = ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {

            ret = (ch - 'a') + 10;
        }

        return ret;

    }

}
