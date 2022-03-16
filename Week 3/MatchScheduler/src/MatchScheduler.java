import java.util.*;

public class MatchScheduler {
    private final int weekCount;
    private final List<String> teams;
    private final HashMap<Integer, List<Match>> schedule;
    private final int[][] scheduleMatrix;

    public MatchScheduler(List<String> teams) {
        // Randomize the teams
        Collections.shuffle(teams);

        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }
        int teamSize = teams.size();

        this.weekCount = (teamSize * (teamSize - 1)) / (teamSize / 2);
        this.teams = teams;
        this.scheduleMatrix = new int[teamSize][teamSize];
        schedule = new HashMap<>();
    }

    public void initScheduleMatrix() {
        scheduleMatrix[0][0] = 1;

        // Column-wise traversal
        int entry = 1;
        for (int i = 0; i < scheduleMatrix[0].length; i++) {
            for (int j = 0; j < scheduleMatrix.length; j++) {
                if (i == j) {
                    scheduleMatrix[teams.size() - 1][j] = entry;
                } else if (j != teams.size() - 1) {
                    scheduleMatrix[j][i] = entry;
                }

                if (++entry == teams.size()) {
                    entry = 1;
                }
            }
        }

        initSchedule();
    }

    private void initSchedule() {
        for (int i = 0; i < scheduleMatrix[0].length; i++) {
            for (int j = 0; j < scheduleMatrix.length; j++) {
                if (i == j) continue;

                int weekNumber = (j > i) ? scheduleMatrix[j][i] : scheduleMatrix[j][i] + (weekCount / 2);
                Match match = new Match(teams.get(i), teams.get(j));
                List<Match> matches;

                if (schedule.get(weekNumber) == null) {
                    matches = new ArrayList<>();
                } else {
                    matches = schedule.get(weekNumber);
                }

                matches.add(match);
                schedule.put(weekNumber, matches);
            }
        }

        for (Map.Entry<Integer, List<Match>> set : schedule.entrySet()) {
            List<Match> matches = set.getValue();

            System.out.println("----- Week " + set.getKey() + " -----");
            for (Match match: matches) {
                System.out.println(match);
            }
            System.out.println();
        }
    }
}
