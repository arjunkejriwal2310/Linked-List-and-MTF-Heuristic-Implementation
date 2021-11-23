public class WordList
{
    public static void main(String[] args)
    {
        RunTimer timer1 = new RunTimer();
        RunTimer timer2 = new RunTimer();

        WordReader wr1 = new WordReader("C:\\Users\\Arjun Kejriwal\\IdeaProjects\\Assignment 2 (COSC-211)\\src\\MobyDick.txt");
        WordReader wr2 = new WordReader("C:\\Users\\Arjun Kejriwal\\IdeaProjects\\Assignment 2 (COSC-211)\\src\\MobyDick.txt");

        SimpleUSet<String> LinkedSet = new LinkedSimpleUSet<String>();
        SimpleUSet<String> MTFSet = new MTFSimpleUSet<String>();
        LinkedSimpleUSet<String> LinkedSetAlt = (LinkedSimpleUSet) LinkedSet;
        MTFSimpleUSet<String> MTFSetAlt = (MTFSimpleUSet) MTFSet;

        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println(" ");

        String word2 = wr2.nextWord();
        int b = 0;

        while(word2 != null)
        {
            timer2.start();
            MTFSet.add(word2);
            word2 = wr2.nextWord();

            b++;
            if(b % 5000 == 0)
            {
                System.out.println(timer2.getElapsedMillis());
            }
            timer2.stop();
        }

        String word1 = wr1.nextWord();
        int a = 0;

        while(word1 != null)
        {
            LinkedSet.add(word1);
            word1 = wr1.nextWord();
        }
    }
}
