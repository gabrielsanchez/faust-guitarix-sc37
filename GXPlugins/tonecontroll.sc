Faust3BandEQ : MultiOutUGen
{
  *ar { | in1, in2, bass(0.0), middle(0.0), on(0.0), treble(0.0), sharper(-2.0) |
      ^this.multiNew('audio', in1, in2, bass, middle, on, treble, sharper)
  }

  *kr { | in1, in2, bass(0.0), middle(0.0), on(0.0), treble(0.0), sharper(-2.0) |
      ^this.multiNew('control', in1, in2, bass, middle, on, treble, sharper)
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

  name { ^"Faust3BandEQ" }


  info { ^"Generated with Faust" }
}

