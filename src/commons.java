

public interface commons {

	//board
    public static final int BOARD_WIDTH = 1024; //board width
    public static final int BOARD_HEIGHT = 768; //board height
    
    //runtime
    public final int TICKS_PER_SECOND = 25;
    public final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    public final int MAX_FRAMESKIP = 5;
}
