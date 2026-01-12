/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
*/

class Solution {
    public boolean isValid(String s) {
        int para = 0;
        int curly = 0;
        int square = 0;
        List<String> last = new ArrayList<>();
        int size = -1;

        OUTER_LOOP:
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            switch (c) {
                case '(':
                    para++;
                    size++;
                    last.add("para");
                    break;
                case ')':
                    if (size > -1 && last.get(size) == "para") {
                        para--;
                        last.remove(size);
                        size--;
                        break;
                    } else {
                        para = 1;
                        break OUTER_LOOP;
                    } 
                case '{':
                    curly++;
                    size++;
                    last.add("curly");
                    break;
                case '}':
                    if (size > -1 && last.get(size) == "curly") {
                        curly--;
                        last.remove(size);
                        size--;
                        break;
                    } else {
                        curly = 1;
                        break OUTER_LOOP;
                    } 
                case '[':
                    square++;
                    size++;
                    last.add("square");
                    break;
                case ']':
                    if (size > -1 && last.get(size) == "square") {
                        square--;
                        last.remove(size);
                        size--;
                        break;
                    } else {
                        square = 1;
                        break OUTER_LOOP;
                    } 
            }
        }

        return para == 0 && curly == 0 && square == 0;
    }
}
