FaustFlangerMono : UGen
{
  *ar { | in1, level(0.0), lfobpm(24.0), wet_dry(100.0) |
      ^this.multiNew('audio', in1, level, lfobpm, wet_dry)
  }

  *kr { | in1, level(0.0), lfobpm(24.0), wet_dry(100.0) |
      ^this.multiNew('control', in1, level, lfobpm, wet_dry)
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

  name { ^"FaustFlangerMono" }


  info { ^"Generated with Faust" }
}

