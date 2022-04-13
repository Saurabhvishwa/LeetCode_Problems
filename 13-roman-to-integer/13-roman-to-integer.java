class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;
        int result = 0;
        while(index<n){
            if(index<n-1 && arr[index] == 'C' && arr[index+1] == 'M'){
            index+=2;
            result += 900;
        }else if(arr[index] == 'M'){
            index+=1;
            result += 1000;
        }else if(index<n-1 && arr[index] == 'C' && arr[index+1]=='D'){
                index+=2;
                result+=400;
            }else if(arr[index] == 'D'){
                index++;
                result+= 500;
            }
            else if(index<n-1 &&arr[index] == 'X' && arr[index+1] == 'C'){
            index+=2;
            result += 90;
        }else if(arr[index] == 'C'){
            index+=1;
            result += 100;
        }else if(index<n-1 &&arr[index] == 'X' && arr[index+1] == 'L'){
            index+=2;
            result += 40;
        }else if(arr[index] == 'L'){
            index+=1;
            result += 50;
        }else if(index<n-1 && arr[index] == 'I' && arr[index+1] == 'X'){
                index+=2;
                result+=9;
            }else if(arr[index] == 'X'){
                index++;
                result += 10;
            }
            else if(index<n-1 &&arr[index] == 'I' && arr[index+1] == 'V'){
            index+=2;
            result += 4;
        }else if(arr[index] == 'V'){
            index+=1;
            result += 5;
        }else{
            index++;
            result += 1;
            }
        }
        return result;
    }
}