public class Stack {
    int maxSize;
    int endHigh;
    int endMedium;
    int endLow;
    int front;
    int numberOfItems;
    String stack[];
    public Stack(int n) {
        maxSize = n;
        stack = new String[maxSize];
        front = 0;
        endHigh = 0;
        endMedium = 0;
        endLow = 0;
        numberOfItems = 0;
    }

    public void send(String signal, String priority) {
        if(endHigh+1 < maxSize || endMedium+1 < maxSize || endLow < maxSize)
            if(priority.equals("low")) {
                if((endLow != endMedium || endLow != endHigh)) {
                    if( endHigh > endMedium) {
                        for (int i = endHigh; i > endLow+1; i--) {
                            stack[i + 1] = stack[i];
                        }
                    }
                    else {
                        for (int i = endMedium; i > endLow+1; i--) {
                            stack[i + 1] = stack[i];
                        }
                    }
                }
                stack[endLow+1] = signal;
                endLow++;
                endMedium++;
                endHigh++;
                numberOfItems++;
            }
        if(priority.equals("Medium")) {
            if((endMedium != endHigh)) {
                for (int i = endHigh; i > endMedium+1; i--) {
                    stack[i + 1] = stack[i];
                }
            }
            stack[endMedium+1] = signal;
            endMedium++;
            endHigh++;
            numberOfItems++;
        }
        if(priority.equals("High")) {
            stack[endHigh+1] = signal;
            endHigh++;
            numberOfItems++;
        }
        else
            throw new ArrayIndexOutOfBoundsException();

    }
    public String recieve() {
        String temp = this.get();
        stack[numberOfItems-1] = null;
        numberOfItems--;
        return temp;
    }
    public String get() {
        return stack[numberOfItems-1];
    }

}