public class CodingChallenges {
    public static void main(String args[]) {

        //   int[] numberArr = {1,2,2,3};
        //   int[] result = removeDuplicate(numberArr);
        //   for(int i = 0; i<result.length; i++) {
        //     System.out.println(result[i]);
        //   }


        // int reverseNum = reverseInteger(123);

//   System.out.println(frequentlyOccure(new int[]{4,1,2,4,2,3,0,4,4,1,4,2} ));
//   System.out.println(nUpCount(new int[]{2,3,1,-6,8,-3,-1,2},5));
//   System.out.println(isMadhavArray(new int[]{2,1,1,4,-1,-1} ));
//   System.out.println(decodeArray(new int[]{-1, 5, 8, 17, 15} ));
//   System.out.println(decodeArray(new int[]{111, 115, 118, 127, 125} ));
//   System.out.println(sumFactor(new int[]{1}));
//   System.out.println(sumFactor(new int[]{0,0,0}));
//   System.out.println(findPorcupineNumber(0));
//   System.out.println(findPorcupineNumber(30));
//   System.out.println(findPorcupineNumber(138));
        // System.out.println(isPacked(new int[]{2, 2, 1}));
        // System.out.println(isPacked(new int[]{2, 2, 1, 2, 2}));
        // System.out.println(isPacked(new int[]{4, 4, 4, 4, 1, 2, 2, 3, 3, 3}));
        // System.out.println(isPacked(new int[]{7, 7, 7, 7, 7, 7, 7, 1}));
        // System.out.println(isPacked(new int[]{7, 7, 7, 7, 1, 7, 7, 7}));
        // System.out.println(isPacked(new int[]{7, 7, 7, 7, 7, 7, 7}));
        // System.out.println(isPacked(new int[]{}));
        // System.out.println(isPacked(new int[]{1, 2, 1}));
        // System.out.println(isPacked(new int[]{2, 1, 1}));
        // System.out.println(isPacked(new int[]{-3, -3, -3}));
        //  System.out.println(isSequencedArray(new int[]{1, 2, 3, 4, 5}, 1, 5));
        //  System.out.println(isSequencedArray(new int[]{1, 3, 4, 2, 5}, 1, 5));
        // System.out.println(isSequencedArray(new int[]{-5, -5, -4, -4, -4, -3, -3, -2, -2, -2}, -5, -2));
        // System.out.println(isSequencedArray(new int[]{0, 1, 2, 3, 4, 5}, 1, 5));
        // System.out.println(isSequencedArray(new int[]{1, 2, 3, 4}, 1, 5));


        System.out.println(isMinMaxDisjoint(new int[]{5, 4, 1, 3, 2}));
        System.out.println(isMinMaxDisjoint(new int[]{18, -1, 3, 4, 0}));
        System.out.println(isMinMaxDisjoint(new int[]{9, 0, 5, 9}));
        System.out.println(isMinMaxDisjoint(new int[]{0, 5, 18, 0, 9}));
        System.out.println(isMinMaxDisjoint(new int[]{7, 7, 7, 7}));
        System.out.println(isMinMaxDisjoint(new int[]{}));
        System.out.println(isMinMaxDisjoint(new int[]{1, 2}));
        System.out.println(isMinMaxDisjoint(new int[]{1}));




    }

    // easy
    static int[] clusterCompression(int[] a){return new int[]{0};}
    static int isSumSafe(int[] a) {return 0;}


    static int isMinMaxDisjoint(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minAppearance = 0;
        int maxAppearance = 0;
        int minPosition = 0;
        int maxPosition = 0;



        for(int i=0; i<a.length;i++) {

            // new max
            if(a[i] > max) {
                max = a[i];
                maxPosition = i;
                maxAppearance = 1;
                // new min
            } else if(a[i] < min) {
                min = a[i];
                minPosition = i;
                minAppearance = 1;
            }

            // check for duplicate
            else {
                if(a[i] == min) minAppearance++;
                if(a[i] == max) maxAppearance++;
            }
        }

        // check if we match all condition provided in the question
        if(min == max || maxPosition == minPosition + 1 || maxPosition == minPosition - 1 || minAppearance != 1 || maxAppearance != 1) return 0;

        return 1;
    }



    static int is121Array(int[] a) {
        // minimum 3 elements
        // start and ends with 1's
        if(a.length < 3 || a[0] != 1 || a[a.length-1] != 1) return 0;

        int count1 = 0;
        int count2 = 0;


        // count 1's and 2's other numbers invalid
        for(int i=0;i<a.length;i++) {
            if(a[i] == 1) {
                count1++;
            } else if(a[i] == 2) {
                count2++;
            } else {
                return 0;
            }
        }

        // check if the 1's and 2's are sorted. 1's at start and end
        for(int j=0,k=a.length-1;j<count1 && k>=a.length-count1; j++, k--) {
            if(a[j] != a[k]) return 0;
        }

        // if no 1's or 2's or no even 1's to left and right
        if(count1 !=0 && count1 % 2 == 0 && count2 !=0) return 1;

        return 0;
    }

    static int isOddHeavy(int[] a) {

        boolean hasOddValue = false;
        int smallestOdd = Integer.MAX_VALUE;
        int largestEven = Integer.MIN_VALUE;



        for(int i=0;i<a.length; i++) {
            if(a[i] % 2 == 0) {
                if(a[i] > largestEven) largestEven = a[i];
            } else {
                hasOddValue = true;
                if(a[i] < smallestOdd) smallestOdd = a[i];
            }
        }

        if(hasOddValue) {
            return smallestOdd > largestEven ? 1 : 0;
        }

        return 0;
    }


    static int isSequencedArray(int[] a, int m, int n) {
        if(a[0] != m || a[a.length-1] != n) return 0;

        for(int i=0; i<a.length-1 ;i++) {

            // if next item not the equal or sequential to current
            if(a[i+1] - a[i] != 0 && a[i+1] - a[i] != 1) return 0;
        }


        return 1;
    }


    static int matchPattern(int[] a, int[] pattern) {
        // check if first and last element match with the pattern
        if(a[0] != pattern[0] || a[a.length-1] != pattern[pattern.length-1]){
            return 0;
        }

        int count = 0;

        // first and last elements checked start from 1 and before last index
        for(int i=1; i<a.length-1; i++) {

            // check if next item isn't same number as current
            // if not the same then current number should be equal to pattern[count-1]
            if(a[i] != a[i+1]) {
                count++;
                if(pattern[count - 1] != a[i]) return 0;
            }
        }

        return 1;
    }


    static int isPacked(int[] a) {
        int j = 0;


        // iterate not one by one
        // iterate the current number of time
        // if current number is 2 iterate index [0,1] and check if there are 2's
        // next iteration will be at index 2(i) after index[0,1] are checked
        // so if any of the items don't have as many occurence as the number it self the array is invalid
        for (int i = 0; i < a.length; i = j) {
            int count = 0;
            // 0 shouldn't occur
            if (a[i] <= 0) return 0;

            // the number should occur the number of times the number it self. If  current no 2 current no and next should be 2 iterate 2 times and check if valid
            // iterate from current index poistion(i) to what a[i] holds meaning if index i is 0 and a[i] is 2 we iterate till i + a[i] = 0 + 2 = 2 [We iterate the number it self time]
            for (j = i; j < i + a[i]; j++) {
                if (a[i] != a[j]) {
                    return 0;
                } else {
                    count++;
                }
            }



            // count the current number occurence till the end
            // we may have the number occuring non-consecuatively eg: [2,2,1,2]
            for (int anA : a) {
                if (anA == a[i])
                    count++;
            }

            // check if there are more than number it self
            if (count > a[i])
                return 0;
        }

        return 1;
    }




    static int isRailroadTie(int[] a) {
        if(a[0] == 0 || a[a.length - 1] == 0 || a.length <=1) {
            return 0;
        }

        // first and last items already check
        // fisrt and last items are okay if they aren't zero
        for(int i=1; i<a.length-1; i++) {

            // non-positive zero number
            // check if both are non-zero if no it's false
            if(a[i] == 0 && (a[i-1] < 0 && a[i+1] < 0)) {
                return 0;
            }
            // positive non-zero
            // check if both neighbours are zero or non-zero which is false
            else if(a[i] != 0 && ((a[i-1] != 0 && a[i+1] != 0) || (a[i-1] == 0 && a[i+1] ==0))) {
                return 0;
            }
        }

        return 1;
    }


    // check if the duplicates in the array are bigger than the number it self
    // check also is the numbers are consucative
    static int isSequentiallyBounded(int[] a) {
        if(a.length == 0) return 1;


        int sequenceCount = 0;
        int currentNum = a[0];

        for(int i=0;i<a.length-1;i++) {

            // if item 0 & negative
            // if items not consucative
            if(a[i] < 1 || a[i] > a[i+1]) return 0;

            if(a[i] == currentNum) {
                sequenceCount++;
                if(sequenceCount >= a[i]) return 0;
            } else {
                currentNum = a[i];
                sequenceCount = 0;
            }


        }

        return 1;
    }


    // when adding the items how many time does the sum go up than the give number n
    static int nUpCount(int[] a, int n){
        int nCount = 0;
        int partialSum = 0;
        int previousPartialSum = 0;

        for(int i=0;i<a.length;i++) {
            previousPartialSum = partialSum;
            partialSum += a[i];

            // if previous was less than or equal to n
            // And if current if greater than n
            // mean there is increment and n goes up by one
            if(previousPartialSum <= n && partialSum > n) {
                nCount++;
            }
        }

        return nCount;
    }

    // covert number to the multiplication of there dividers
    static int[] encodeNumber(int n) {
        if(n<=1) return null;

        // first step calculate the size of array to return
        int size = 0;
        int copyNum = n;

        // start from 2 divide the number only increment manualy when current number no divisible by 2 or other after that
        for(int i=2; i<=copyNum;) {

            // check if it divisible and isPrime
            if(isPrime(i) == 1 && copyNum % i == 0) {
                size++;
                copyNum = copyNum/i;
            } else {
                i++;
            }
        }

        int[] result = new int[size];
        copyNum = n;

        // do it again find the factors of the number which are prime and add them to the new array
        for(int i=0, k=2; i<size && k<=copyNum;) {
            if(isPrime(k) == 1 && copyNum % k == 0) {
                result[i] = k;
                copyNum = copyNum/k;
                i++;
            } else {
                k++;
            }

        }

        return result;
    }


    public static int henry(int i, int j) {
        int perfectCount = 0;
        int result = 0;
        int max = Integer.MAX_VALUE;

        for(int x=1; x<=max; x++) {
            int sum = 0;

            for(int y=1; y<x; y++) {
                if(x % y == 0) {
                    sum += y;
                }
            }

            if(sum == x) {
                perfectCount++;
                if(i == perfectCount) {
                    result += sum;
                }

                if(j == perfectCount) {
                    result += sum;
                    break;
                }
            }
        }


        return result;

    }


    static int frequentlyOccure(int[] a) {
        int mostFrequentCount = 0;
        int mostFrequentItem = 0;

        for(int i=0; i<a.length; i++) {
            int currentFrequentCount = 0;
            for(int j=i+1; j<a.length; j++) {
                if(a[i] == a[j]) {
                    currentFrequentCount++;
                }
            }
            if(currentFrequentCount > mostFrequentCount) {
                mostFrequentCount = currentFrequentCount;
                mostFrequentItem = a[i];
            }
        }

        return mostFrequentItem;
    }




    static int isPerfectSquare(int n) {
        if(n<0) return 0;

        int squareResult = (int) Math.sqrt(n);
        int nextNumber = squareResult + 1;
        int nextSquare = (int) Math.pow(nextNumber,2);

        return nextSquare;
    }


    // a[0]= a[1] + a[2] = a[3] + a[4] | a[5]
    static int isMadhavArray(int[] a) {
        //Eg: {2,1,1}
        int index = 1; // index where we start adding the new array to compare. So second index
        int madhavArraysLength = 1; // length how many sets we have that sum up to be equal to a[0]

        for(int i=2;i<a.length;i++) {
            int count = i; // the iteration amount we have to go every time to add increases by one every time
            int sum = 0; // the sum of each set to compare with a[0]

            if(index > a.length - 1) break;
            if(index + madhavArraysLength > a.length - 1) return 0;

            while(count!=0) {
                sum += a[index];
                index++;
                count--;
            }

            // check if the new set is equal to a[0]
            if(sum != a[0]) return 0;
            else madhavArraysLength++;
        }

        // check if it meets madhav formula n * (n+1)/2 == Array length
        if(madhavArraysLength * (madhavArraysLength + 1)/2 != a.length) return 0;


        return 1;
    }

    static int isPrime(int n) {
        if(n < 1) return 0;

        for(int i=2;i<n;i++) {
            if(n % i == 0) return 0;
        }

        return 1;
    }


    static int findPorcupineNumber(int n) {

        int porcupineNumber = 0;
        boolean foundPorcupine = false;
        n++;

        while(n<=Integer.MAX_VALUE) {
            if(foundPorcupine) {
                if(isPrime(n) == 1) {
                    if(n%10 == 9) {
                        return porcupineNumber;
                    } else {
                        foundPorcupine = false;
                    }
                }
            } else {
                if(isPrime(n) == 1) {
                    if(n%10 == 9) {
                        foundPorcupine = true;
                        porcupineNumber = n;
                    }
                }
            }
        }

        return porcupineNumber;
    }


    static int isStackedNumber(int n) {
        int sum=0;

        for(int i=1;i<n;i++) {
            sum += i;
            if(sum == n) return 1;
            if(sum > n) return 0;
        }


        return 0;
    }


    static int isSquare(int n) {

        for(int i=0;i<=n;i++) {
            if(n ==  i*i) return 1;
        }


        return 0;
    }


    static int isNUnique(int[] a, int n) {
        if(a.length < 2) return 0;
        boolean foundNUnique = false;

        for(int i=0;i<a.length;i++) {
            for(int j=i+1;j<a.length;j++) {

                // check if they sum up to n if so check if it is duplicate or unique
                if(a[i] + a[j] == n) {
                    if(foundNUnique) return 0;
                    else foundNUnique = true;
                }
            }
        }

        return foundNUnique ? 1 : 0;
    }


    static int convertToBase10(int[] a, int base) {
        int sum = 0;

        // eg {1,1,2},3 => 1*3^2 + 1*3^1 + 2*3^0
        // so basically converting to base 10 has this formula [currentItem * base^power] currentItem increases & power decreases from highest
        for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
            if (a[i] >= base) return 0;
            sum += a[i] * Math.pow(base, j);
        }

        return sum;
    }


    static int[] solve10() {
        int factorialX = 1;
        int factorialY = 1;
        int x = 1;
        int y = 1;
        boolean matched = false;
        int tenFactorial = 1;
        int[] result = new int[2];

        for (int i = 1; i <= 10; i++) {
            tenFactorial *= i;
        }

        for (x = 1; x <= 10 && !matched; x++) {
            factorialX *= x;
            factorialY = 1;
            for (y = 1; y <= 10 && !matched; y++) {
                factorialY *= y;
                if (tenFactorial == factorialX + factorialY) {
                    matched = true;
                    break;
                }
            }
            if(matched) {
                break;
            }
        }

        if (matched) {
            result[0] = x;
            result[1] = y;
        } else {
            result[0] = 0;
            result[1] = 0;
        }

        System.out.println(result[0]);
        System.out.println(result[1]);

        return result;

    }


    static int sumFactor(int[] a){
        if(a.length == 1) return 1;
        int sumOfArray = 0;
        int occurenceOfSum = 0;

        for(int i=0; i<a.length;i++){
            sumOfArray += a[i];
        }

        for(int j=0;j<a.length;j++){
            if(a[j] == sumOfArray) occurenceOfSum++;
        }

        return occurenceOfSum;
    }


    static int stantonMeasure(int[] a){
        if(a.length == 0) return 0;
        int countOfOnes = 0;
        int stantonMeasure = 0;

        for(int i=0; i<a.length;i++){
            if(a[i] == 1) countOfOnes++;
        }

        for(int j=0;j<a.length;j++){
            if(a[j] == countOfOnes) stantonMeasure++;
        }

        return stantonMeasure;
    }

    static int isGuthrieSequence(int[] a) {
        if(a[a.length-1] != 1) return 0;
        int currentSequence = a[0];

        for(int i=1; i<a.length;i++) {
            if(currentSequence%2==0) currentSequence = currentSequence/2;
            else currentSequence = (currentSequence*3) + 1;
            if(currentSequence != a[i]) return 0;
        }

        return 1;
    }


    static int isCentered15(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == 15) {

                    // finding if they are centered element
                    // if the ending index j is decremented from the total if array is centered is should be equal to start of the centered elements i.
                    // -1 is required as i and j are indexes and a.length is not index gives the real count doesn't start/count behind starting from 0
                    // [startingIndex == arrayLength - endingIndex - 1]
                    if (i == a.length - j - 1)
                        return 1;
                }
            }
        }

        return 0;

    }


    static int decodeArray(int[ ] a) {
        int sum = 0;

        for(int i=0; i<a.length-1; i++) {
            // absolue difference between a and a+1
            int digit = (a[i] - a[i+1] > 0) ? a[i] - a[i+1] : -(a[i] - a[i+1]);

            // coverting to 1000, 100, 10 ....
            // eg for 1st items we'll add 3zeros, 2nd items 2zeros ....
            for(int j=i+2; j<a.length; j++) {
                digit *= 10;
            }

            sum += digit;
        }

        if(a[0] < 0) return -sum;
        return sum;
    }


    static int isCubePowerful(int n) {
        if(n <= 0) return 0;
        int originalN = n;
        int sum = 0;
        while(n != 0) {
            int lastDigit = n%10;
            sum += lastDigit * lastDigit * lastDigit;
            n = n/10;
        }

        return originalN == sum ? 1 : 0;
    }


    static void doIntegerBasedRounding(int[ ] a, int n) {
        // if n <=0, no elements of the array are modified
        if(n <= 0) return;

        for(int i=0; i<a.length; i++) {
            // A negative element of the array is not modified
            if(a[i] >= 0 ) {
                int lowerBound = (a[i]/n)*n;
                int upperBound = lowerBound + n;
                int middleElement = (n % 2 == 0) ? lowerBound + n/2 : lowerBound + n/2 + 1;

                // number is greater than middle element round to upper bound
                if(a[i] >= middleElement) a[i] = upperBound;
                else a[i] = lowerBound;
            }

            System.out.println(a[i]);
        }
    }


    static int hasSingleMaximum(int[] a) {
        if(a.length == 0) return 0;
        int max = a[0];

        boolean isDuplicated = false;
        for(int i=1;i<a.length;i++){
            if(a[i] > max) {
                max = a[i];
                isDuplicated = false;
            }
            else if(a[i] == max) {
                isDuplicated = true;
            }
        }

        return isDuplicated ? 0 : 1;
    }

    static int is235Array(int[] a) {
        int divisibleCount = 0;

        for(int i=0;i<a.length;i++) {
            if(a[i] % 2 == 0) divisibleCount++;
            if(a[i] % 3 == 0) divisibleCount++;
            if(a[i] % 5 == 0) divisibleCount++;
            if(a[i] % 2 != 0 && a[i] % 3 != 0 && a[i] % 5 != 0) divisibleCount++;
        }

        return divisibleCount == a.length ? 1 : 0;
    }

    static int largestPrimeFactor(int n) {
        if(n <= 1) return 0;
        int number = n;
        while(number > 1) {
            if(n % number == 0) {
                boolean isPrime = true;
                for(int i=2;i<number;i++) {
                    if(number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) return number;
            }


            number--;
        }

        return 0;
    }

    static int checkConcatenatedSum(int n, int catlen) {
        int totalSum = 0;
        int originalNumber = n;

        while(n!=0) {
            int lastDigit = n%10;
            int currentConcat = 0;

            for(int i=0;i<catlen;i++){
                currentConcat = (currentConcat*10) + lastDigit;
            }

            totalSum += currentConcat;
            n= n/10;
        }

        return originalNumber == totalSum ? 1 : 0;
    }


    static int largestAdjestSum(int[] a) {
        // initially holds the minimum integer possible
        int max = Integer.MIN_VALUE;

        for(int i=0; i<a.length-1; i++) {
            if(a[i] + a[i+1] > max) max = a[i] + a[i+1];
        }

        return max;
    }


    static int reverseInteger(int givenInteger) {
        int sign = 1;
        if(givenInteger == 0) return givenInteger;

        if(givenInteger < 0) {
            sign = -1;
            givenInteger = (-1) * givenInteger;
        }

        int reverse = 0;

        while(givenInteger != 0) {
            reverse = (reverse * 10) + (givenInteger % 10);
            givenInteger = givenInteger/10;
        }

        return sign * reverse;
    }

    static int[] removeDuplicate(int[] givenArray) {
        if(givenArray.length == 0 || givenArray == null) {
            return givenArray;
        } else {
            int[] uniqueArr = new int[givenArray.length];
            int uniqueCount = 0;
            boolean isDuplicate = false;

            for(int i=0; i<givenArray.length; i++) {
                for(int j=0; j<uniqueArr.length; j++) {
                    isDuplicate = false;
                    if(givenArray[i] == uniqueArr[j]) {
                        isDuplicate = true;
                        break;
                    }

                }


                if(isDuplicate == false) {
                    uniqueArr[i] = givenArray[i];
                    uniqueCount++;
                }


            }

            if(uniqueCount == uniqueArr.length) {
                return uniqueArr;
            } else {
                int[] output = new int[uniqueCount];
                for(int x=0; x<uniqueCount; x++) {
                    output[x] = uniqueArr[x];
                }
                return output;
            }
        }
    }
}