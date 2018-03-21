FaustJconvPostMono : UGen
{
  *ar { | in1, in2, gain(0.0), wet_dry(100.0) |
      ^this.multiNew('audio', in1, in2, gain, wet_dry)
  }

  *kr { | in1, in2, gain(0.0), wet_dry(100.0) |
      ^this.multiNew('control', in1, in2, gain, wet_dry)
  } 

  checkInputs {
    if (rate == 'audio', {
      2.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustJconvPostMono" }


  info { ^"Generated with Faust" }
}

