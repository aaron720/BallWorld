
/**
 * Write a description of class BallRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallRunner
{
    private BallWorld bw;
    private TGPoint entrancePoint;
    private BallBot[] ballBotArray;
    public BallRunner(BallWorld bw, TGPoint entrancePoint, int ballsArrayLength) {
        bw = bw;
        entrancePoint = entrancePoint;
        ballBotArray = new BallBot[ballsArrayLength];
    }
    public int findFreeBallBotIndex(){
        for (int i=0; i<ballBotArray.length;i++){
            if (ballBotArray[i] == null){
                return i;
            } 
        }
        return ballBotArray.length;
    }
    public static void run(){
        BallWorld bw = new BallWorld(300, 300);
        TGPoint entrancePoint = new TGPoint ((int)(Math.random()*100),(int)(Math.random()*100));
        int ballsArrayLength = 100;
        BallRunner ball = new BallRunner(bw, entrancePoint, ballsArrayLength);
        while(true) {
            int freeBallBotIndex = ball.findFreeBallBotIndex();
               if (freeBallBotIndex < ballsArrayLength) {
                BallBot ballBot = new BallBot(bw, entrancePoint, (int)(Math.random()*360), (int)(Math.random()*10));
                ball.ballBotArray[freeBallBotIndex] = ballBot;
 
            }
            for (int i = 0; i <ball.ballBotArray.length; i++){
                if (ball.ballBotArray[i] != null){
                    if (ball.ballBotArray[i].canMoveForward(bw)) {
                        ball.ballBotArray[i].moveForward();
                    } else {
                        ball.ballBotArray[i].setHeading(Math.random()*360);
                    }
                }
            }
        }
    }
       }
    //public static void main(String args[]) {
      //  int width = 200;
        //int height = 200; 
       // TGPoint startPoint = new TGPoint(0, 0);
       // double startHeading = 0;
       // int radius = 25;
       // BallWorld bw = new BallWorld(width, height);
       // BallBot bb = new BallBot(bw, startPoint, startHeading, radius);
       // while(true) {
         //   if(bb.canMoveForward(bw)){
          //      bb.moveForward();
            //} else {
              //  bb.setHeading(Math.random()*360);
            //}
//      }
  //  }
    
//}
