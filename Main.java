import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Main {
	// easy lookup table for the answers, to clean up code below
	private static final String[] answers = {
		"$98,345 average salary in South Florida!",
		"US News - 100 Best Jobs!",
		"Top 10 Forbes In-Demand Jobs!"
	};

	public static void main(String[] args) throws FileNotFoundException {
		var students = new ArrayList<String>();

		try (var scn = new Scanner(new FileReader("names.txt"))) { // auto-close scanner
			while (scn.hasNext()) students.add(scn.nextLine());
		}

		try (var scn = new Scanner(System.in)) {
			var quit = false;
			while (!quit) quit = isQuitting(scn, students);
		}
	}

	private static boolean isQuitting(Scanner in, ArrayList<String> students) {
		// This is a text block, used to not split lines into multiple statements:
		System.out.println("""
					Press 1 to learn about salary.
					Press 2 to learn about the job.
					Press 3 to learn about demand.
					Press 4 to view current students.
					Press 5 to quit.""");

		var ans = in.nextInt();
		if (ans == 5) return true;
		
		if (ans < 4) {
			System.out.println(answers[ans - 1]);
		} else for (var e : students) System.out.println(e);

		return false;
	}
}
