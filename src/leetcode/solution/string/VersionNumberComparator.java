package leetcode.solution.string;

import leetcode.util.ArrayUtil;

/**
 * 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号
 * 分别为 3 和 4。其第三级和第四级修订号均为 0。
 *
 * 示例 1:
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 *
 * 示例 2:
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 *  
 *
 * 提示：
 *
 * 版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
 * 版本字符串不以点开始或结束，并且其中不会有两个连续的点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VersionNumberComparator {

    public int compareVersion(String version1, String version2) {

        int[] vs1 = canonicalVersions(version1);
        int[] vs2 = canonicalVersions(version2);
        int len = Math.max(vs1.length, vs2.length);
        for (int i = 0; i < len; i++) {
            if (i >= vs2.length) {
                while (i < vs1.length) {
                    if (vs1[i] > 0) {
                        return 1;
                    }
                    i++;
                }
            } else if (i >= vs1.length) {
                while (i < vs2.length) {
                    if (vs2[i] > 0) {
                        return -1;
                    }
                    i++;
                }
            } else if (vs1[i] > vs2[i]) {
                return 1;
            } else if (vs1[i] < vs2[i]) {
                return -1;
            }
        }
        return 0;
    }

    private int[] canonicalVersions(String versionStr) {

        int[] versions = new int[versionStr.length() / 2 + 1];
        int versionCount = 0;
        int version = 0;

        for (int i = 0; i < versionStr.length(); i++) {
            char c = versionStr.charAt(i);
            if (c == '.') {
                versions[versionCount++] = version;
                version = 0;
            } else if (c != '0' || version > 0) {
                version = version * 10 + c - '0';
            }
        }
        versions[versionCount] = version;
        return versions;
    }

    public static void main(String[] args) {
        VersionNumberComparator comparator = new VersionNumberComparator();
        System.out.println(comparator.compareVersion("0.1", "1.1"));
        System.out.println(comparator.compareVersion("1.0.1", "1"));
        System.out.println(comparator.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(comparator.compareVersion("1.10", "1.1"));
        System.out.println(comparator.compareVersion("7.00011", "7.0101"));
    }
}
