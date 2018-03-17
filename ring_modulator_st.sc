FaustRingModulator : MultiOutUGen
{
  *ar { | in1, in2, dry_wet(0.5), freq(240.0) |
      ^this.multiNew('audio', in1, in2, dry_wet, freq)
  }

  *kr { | in1, in2, dry_wet(0.5), freq(240.0) |
      ^this.multiNew('control', in1, in2, dry_wet, freq)
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

  name { ^"FaustRingModulator" }


  info { ^"Generated with Faust" }
}

