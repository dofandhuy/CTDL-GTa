// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Cala {
  String owner;
  int horn,color;
  Cala() {
   }
  Cala(String xOwner, int xHorn, int xColor){
    owner=xOwner;horn=xHorn; color=xColor;
   }
  public String toString(){
    return("(" +owner+","+horn + "," + color + ")");
   }
 }
