FaustPeakEQ : UGen
{
  *ar { | in1, bandwidth1(41.0), bandwidth2(220.0), bandwidth3(880.0), bandwidth4(1760.0), level1(0.0), level2(0.0), level3(0.0), level4(0.0), peak1(110.0), peak2(440.0), peak3(1760.0), peak4(3520.0) |
      ^this.multiNew('audio', in1, bandwidth1, bandwidth2, bandwidth3, bandwidth4, level1, level2, level3, level4, peak1, peak2, peak3, peak4)
  }

  *kr { | in1, bandwidth1(41.0), bandwidth2(220.0), bandwidth3(880.0), bandwidth4(1760.0), level1(0.0), level2(0.0), level3(0.0), level4(0.0), peak1(110.0), peak2(440.0), peak3(1760.0), peak4(3520.0) |
      ^this.multiNew('control', in1, bandwidth1, bandwidth2, bandwidth3, bandwidth4, level1, level2, level3, level4, peak1, peak2, peak3, peak4)
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

  name { ^"FaustPeakEQ" }


  info { ^"Generated with Faust" }
}

