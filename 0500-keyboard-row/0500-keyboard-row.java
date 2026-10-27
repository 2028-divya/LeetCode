class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        ArrayList<String> ans = new ArrayList<>();

        for (String word : words) {
            String row;

            char ch = Character.toLowerCase(word.charAt(0));

            if (row1.indexOf(ch) != -1) {
                row = row1;
            } else if (row2.indexOf(ch) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;

            for (int i = 1; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));

                if (row.indexOf(c) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }
}