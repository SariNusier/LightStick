//i r g b,i r g b,i r g b,i r g b


int cur_index;
int test = 0;

struct led{
byte r,g,b;
};

struct led leds[288];

void setup() {
  Serial.begin(115200);
}

void loop() {
  if(Serial.available()>0)
    { 
      cur_index = read_group();
      leds[cur_index].r = read_group();
      leds[cur_index].g = read_group();
      leds[cur_index].b = read_group();
      test++; 
    }
  else if(test != 0){
    int i;
    for(i = 0; i<288; i++){
      Serial.print(i);Serial.print(' ');
      Serial.print(leds[i].r);Serial.print(' ');
      Serial.print(leds[i].g);Serial.print(' ');
      Serial.print(leds[i].b);Serial.print(' ');
      Serial.println();
      test = 0;
     } 
  }  
}
  
 int read_group(){
   int ret = 0;
   char readC = 'a';       
       
     while(readC != ' ' && readC != ',' && Serial.available() > 0){
         readC = Serial.read();
         if(readC != ' ' && readC != ',')
           ret = ret * 10 + (readC - '0');
     }
   return ret;   
 }
