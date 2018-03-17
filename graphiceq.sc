FaustGraphicEQ : UGen
{
  *ar { | in1, g10(0.0), g11(0.0), g1(0.0), g2(0.0), g3(0.0), g4(0.0), g5(0.0), g6(0.0), g7(0.0), g8(0.0), g9(0.0) |
      ^this.multiNew('audio', in1, g10, g11, g1, g2, g3, g4, g5, g6, g7, g8, g9)
  }

  *kr { | in1, g10(0.0), g11(0.0), g1(0.0), g2(0.0), g3(0.0), g4(0.0), g5(0.0), g6(0.0), g7(0.0), g8(0.0), g9(0.0) |
      ^this.multiNew('control', in1, g10, g11, g1, g2, g3, g4, g5, g6, g7, g8, g9)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustGraphicEQ" }


  info { ^"Generated with Faust" }
}

