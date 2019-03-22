package AppUtil;

public enum FilePath {
    SETTING ("settings.json"),
    TABLE ("tables.json");

    public final String path;
    private FilePath(String path) {
        this.path = path;
    }
}
