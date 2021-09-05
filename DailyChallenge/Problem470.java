package DailyChallenge;

public class Problem470 {
    public int rand10() {
        while(true) {
            int num = (rand7() - 1) * 7 + rand7();
            if(num <= 40) return num % 10 + 1;
        }
    }

    private int rand7() {
        return 0;
    }
}
