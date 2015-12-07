public class Queue {
    String[] queue;
    int queueSize;
    int front;
    int numberOfItems;
    int endHigh = 0;
    int endMedium = 0;
    int endLow = 0;
    Queue(int size) {
        queueSize = size;
        queue = new String[size];
    }
    public void send(String signal, String priority) {
        if(endHigh+1 < queueSize || endMedium+1 < queueSize || endLow < queueSize) {
            if (priority.equals("High")) {
                if ((endHigh != endMedium || endHigh != endLow)) {
                    if (endLow > endMedium) {
                        for (int i = endLow; i > endHigh + 1; i--) {
                            queue[i + 1] = queue[i];
                        }
                    } else {
                        for (int i = endMedium; i > endHigh + 1; i--) {
                            queue[i + 1] = queue[i];
                        }
                    }
                }
                queue[endHigh + 1] = signal;
                endHigh++;
                endMedium++;
                endLow++;
                numberOfItems++;
            }
            if (priority.equals("Medium")) {
                if ((endMedium != endLow)) {
                    for (int i = endLow; i > endMedium + 1; i--) {
                        queue[i + 1] = queue[i];
                    }
                }
                queue[endMedium + 1] = signal;
                endMedium++;
                endLow++;
                numberOfItems++;
            }
            if (priority.equals("Low")) {
                queue[endLow + 1] = signal;
                endLow++;
                numberOfItems++;
            }
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }

    }
    public String remove() {
        String temp = this.get();
        queue[front] = null;
        front++;
        numberOfItems--;
        return temp;
    }
    public String get() {
        return queue[front];
    }


}