import java.util.*;

class News {
    String title;
    int score;

    News(String t, int s) {
        title = t;
        score = s;
    }
}

public class FakeNewsDetection {

    static String keywords[] = {"shocking","viral","secret","breaking","unbelievable"};

    // Pattern Matching
    static int calculateScore(String title) {

        int score = 0;

        title = title.toLowerCase();

        for(int i=0;i<keywords.length;i++) {

            if(title.contains(keywords[i])) {
                score++;
            }

        }

        return score;
    }

    // Bubble Sort
    static void sortNews(ArrayList<News> list) {

        for(int i=0;i<list.size()-1;i++) {

            for(int j=0;j<list.size()-i-1;j++) {

                if(list.get(j).score < list.get(j+1).score) {

                    News temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);

                }

            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<News> list = new ArrayList<>();

        System.out.println("Enter number of news titles:");

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {

            System.out.println("Enter news title:");

            String title = sc.nextLine();

            int score = calculateScore(title);

            list.add(new News(title,score));

        }

        sortNews(list);

        System.out.println("\nNews Analysis:\n");

        for(News n1 : list) {

            System.out.println("Title: "+n1.title);
            System.out.println("Fake Score: "+n1.score);

            if(n1.score >= 2)
                System.out.println("Result: Possibly Fake News");
            else
                System.out.println("Result: Likely Real News");

            System.out.println();
        }

    }
}