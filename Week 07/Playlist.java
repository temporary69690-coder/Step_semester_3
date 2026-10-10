public class Playlist {
    private static final int MAX_SONGS = 10;
    private String[] songs = new String[MAX_SONGS];
    private int count;

    public void addSong(String title) {
        if (count < MAX_SONGS) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("p.getSongs()[0]: " + p.getSongs()[0]);
        System.out.println("copy[0]: " + copy[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}