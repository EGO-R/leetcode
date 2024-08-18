package neetcode.medium.simplify_path;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/simplify-path/

Given an absolute path for a Unix-style file system, which begins with a slash '/',
transform this path into its simplified canonical path.

In Unix-style file system context, a single period '.' signifies the current directory,
a double period ".." denotes moving up one directory level, and multiple slashes such as "//"
are interpreted as a single slash. In this problem, treat sequences of periods not covered by
the previous rules (like "...") as valid names for files or directories.

The simplified canonical path should adhere to the following rules:

It must start with a single slash '/'.
Directories within the path should be separated by only one slash '/'.
It should not end with a slash '/', unless it's the root directory.
It should exclude any single or double periods used to denote current or parent directories.
Return the new path.
 */
public class Solution {
    public String simplifyPath(String path) {
        var list = parse(path);

        if (list.isEmpty())
            return "/";

        var res = new StringBuilder();
        for (var str : list)
            res.append("/").append(str);

        return res.toString();
    }

    private List<String> parse(String str) {
        var list = new LinkedList<String>();
        var curr = new StringBuilder();
        str += "/";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '/')
                curr.append(str.charAt(i));

            else if (!curr.isEmpty()) {
                var currStr = curr.toString();
                if (currStr.equals("..")) {
                    if (!list.isEmpty())
                        list.removeLast();
                } else if (!currStr.equals("."))
                    list.add(currStr);

                curr.setLength(0);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures"));
    }
}
