FaustTremolo : UGen
{
  *ar { | in1, sine(0.0), depth(0.5), freq(5.0), wet_dry(100.0) |
      ^this.multiNew('audio', in1, sine, depth, freq, wet_dry)
  }

  *kr { | in1, sine(0.0), depth(0.5), freq(5.0), wet_dry(100.0) |
      ^this.multiNew('control', in1, sine, depth, freq, wet_dry)
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

  name { ^"FaustTremolo" }


  info { ^"Generated with Faust" }
}

