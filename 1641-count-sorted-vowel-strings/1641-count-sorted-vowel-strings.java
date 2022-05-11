class Solution {
    static class Count{
        int value = 0;
    }
    public void count(char[] vowels, int index, int n, String s, Count count){
        if(s.length() == n){
            count.value++;
            return;
        }
        for(int i=index;i<vowels.length;i++){
            count(vowels, i, n, s+String.valueOf(vowels[i]), count);
        }
        return;
    }
    public int countVowelStrings(int n) {
        Count count = new Count();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        count(vowels, 0, n, "", count);
        return count.value;
         }
}