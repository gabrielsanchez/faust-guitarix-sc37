FaustStereoVerb : MultiOutUGen
{
  *ar { | in1, in2, lfo_freq(0.2), roomsize(0.5), damp(0.5), invert(0.0), wet_dry(50.0) |
      ^this.multiNew('audio', in1, in2, lfo_freq, roomsize, damp, invert, wet_dry)
  }

  *kr { | in1, in2, lfo_freq(0.2), roomsize(0.5), damp(0.5), invert(0.0), wet_dry(50.0) |
      ^this.multiNew('control', in1, in2, lfo_freq, roomsize, damp, invert, wet_dry)
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

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustStereoVerb" }


  info { ^"Generated with Faust" }
}

