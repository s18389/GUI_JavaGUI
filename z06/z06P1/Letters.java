package z06threat;

import java.util.Iterator;

class Letters   implements Iterable<Thread>{

    public Thread[] threads;
    boolean is_run = true;
    
    public Letters(String letters) 
    {
        threads = new Thread[letters.length()];
        for (int i = 0; i < threads.length; i++) 
        {
            threads[i] = new Thread(new LettersRun(letters.charAt(i)), "Thread " + letters.charAt(i));
        }
    }

    public void start() 
    {
    	is_run = true;
        for (Thread t : threads) 
        {
            t.start();
        }
    }

    public void stop() {is_run = false;}

    
    @Override
    public Iterator<Thread> iterator() {
        Iterator<Thread> threat_2 = new Iterator<Thread>() {

            private int now_index = 0;

            @Override
            public boolean hasNext() { return now_index < threads.length && threads[now_index] != null; }

            @Override
            public Thread next() { return threads[now_index++]; }      
            
        };
        return threat_2;
    }

    private class LettersRun implements Runnable {
        char c;

        private LettersRun(char c) {
            this.c = c;
        }

        @Override
        public void run() {
            while (is_run) {
                System.out.print(c);
                try {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ignored) {}
            }
        }
    }

}