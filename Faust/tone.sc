FaustTone : UGen
{
  *ar { | in1, bass(0.0), middle(0.0), treble(0.0) |
      ^this.multiNew('audio', in1, bass, middle, treble)
  }

  *kr { | in1, bass(0.0), middle(0.0), treble(0.0) |
      ^this.multiNew('control', in1, bass, middle, treble)
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

  name { ^"FaustTone" }


  info { ^"Generated with Faust" }
}

