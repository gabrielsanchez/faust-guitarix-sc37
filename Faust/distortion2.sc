FaustWaveSharper : UGen
{
  *ar { | in1, hfreq(30.0), drive(50.0), freq(10000.0), gain(0.0), wet_dry(100.0) |
      ^this.multiNew('audio', in1, hfreq, drive, freq, gain, wet_dry)
  }

  *kr { | in1, hfreq(30.0), drive(50.0), freq(10000.0), gain(0.0), wet_dry(100.0) |
      ^this.multiNew('control', in1, hfreq, drive, freq, gain, wet_dry)
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

  name { ^"FaustWaveSharper" }


  info { ^"Generated with Faust" }
}

