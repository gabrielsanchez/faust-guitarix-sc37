FaustChorusMono : UGen
{
  *ar { | in1, freq(2.0), level(0.5), wet_dry(100.0) |
      ^this.multiNew('audio', in1, freq, level, wet_dry)
  }

  *kr { | in1, freq(2.0), level(0.5), wet_dry(100.0) |
      ^this.multiNew('control', in1, freq, level, wet_dry)
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

  name { ^"FaustChorusMono" }


  info { ^"Generated with Faust" }
}

