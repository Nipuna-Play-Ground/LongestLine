import java.util.Arrays;

void main(){
    printLongestStraightLine(new int[][]{{2,2},{1,1},{2,1},{3,3},{4,4},{1,3}});
    printLongestStraightLine(new int[][]{{1,3},{1,2},{2,4},{2,2},{3,1},{4,0}});

/*}

int[] returnLongestStraightLine(int[]... coordinatePairs){*/

}

void printLongestStraightLine(int[]... coordinatePair){
    int longestLine = 0;
    double slope = 0;
    double intercept = 0;
    int [][] valueRetainArray = new int[coordinatePair.length][2];

    for (int i = 0; i < coordinatePair.length; i++) {
        for (int j = 0; j < coordinatePair.length; j++) {
            if (coordinatePair[i] != coordinatePair[j]) {
                if (longestLine < (coordinatePair[i][0] * coordinatePair[i][0] + coordinatePair[i][1] * coordinatePair[i][1]) -
                        (coordinatePair[j][0] * coordinatePair[j][0] + coordinatePair[j][1] * coordinatePair[j][1])){
                    longestLine = (coordinatePair[i][0] * coordinatePair[i][0] + coordinatePair[i][1] * coordinatePair[i][1]) -
                            (coordinatePair[j][0] * coordinatePair[j][0] + coordinatePair[j][1] * coordinatePair[j][1]);
                    valueRetainArray[0][0] = coordinatePair[j][0];
                    valueRetainArray[0][1] = coordinatePair[j][1];
                    valueRetainArray[1][0] = coordinatePair[i][0];
                    valueRetainArray[1][1] = coordinatePair[i][1];
                    slope = ((double)(valueRetainArray[1][1] - valueRetainArray[0][1])) / (valueRetainArray[1][0] - valueRetainArray[0][0]);
                    intercept = valueRetainArray[1][1] - ((double)(slope * valueRetainArray[1][0]));
                }else continue;
            }else continue;
        }
    }
    int valueRetainArrayIndex = 2;
    for (int j = 0; j < coordinatePair.length; j++) {
        if (valueRetainArray[0][0] != coordinatePair[j][0] && valueRetainArray[0][1] != coordinatePair[j][1] &&
                valueRetainArray[1][0] != coordinatePair[j][0] && valueRetainArray[1][1] != coordinatePair[j][1]) {
            if (slope == (((double)(valueRetainArray[1][1] - coordinatePair[j][1])) / (valueRetainArray[1][0] - coordinatePair[j][0]))){
                valueRetainArray[valueRetainArrayIndex] = coordinatePair[j];
                valueRetainArrayIndex++;
            } else continue;
        }else continue;
    }

    System.out.println(slope);
    System.out.println(intercept);
    for (int i = 0; i < valueRetainArrayIndex; i++) {
        System.out.print(STR."\{Arrays.toString(valueRetainArray[i])},");
    }
    System.out.println("\b");
}