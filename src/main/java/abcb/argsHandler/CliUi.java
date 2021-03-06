package abcb.argsHandler;

import abcb.InputReader.MyFileReader;
import abcb.algorithm.AlphaBeta;
import abcb.simulate.Position;
import java.io.IOException;
import shakkibeli.kayttoliittyma.Kayttoliittyma;

public class CliUi {

    /**
     * When running bot from command line
     *
     * @param args
     * @throws IOException
     */
    public void run(String[] args) throws IOException {
        System.out.println("args = " + args.length);

        if (args.length == 0) {
            Kayttoliittyma ka = new Kayttoliittyma();

            ka.menu();
        } else if (args.length == 3) {
            System.out.println("File: " + args[0] + "\nTurn: Blacks move");
            MyFileReader mfr = new MyFileReader();
            Position pos = mfr.fileToPosition(args[0]);
            if (args[1].equals("black")) {
                pos.whitesMove = false;
            }
            AlphaBeta ab = new AlphaBeta();
            System.out.println(ab.calculateNextMove(pos, Integer.parseInt(args[2]), pos.whitesMove));
        } else {
//            System.out.println("File: sample.txt\nTurn: Whites move");
            MyFileReader mfr = new MyFileReader();
            Position pos = mfr.fileToPosition("sample.txt");
//            System.out.println("");

            AlphaBeta ab = new AlphaBeta();
            System.out.println(ab.calculateNextMove(pos, 6, true));
        }
    }
}
