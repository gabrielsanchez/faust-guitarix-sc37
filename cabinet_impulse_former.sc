FaustCabinetImpulseFormer : UGen
{
  *ar { | in1, level(1.0), bass(0.0), treble(0.0) |
      ^this.multiNew('audio', in1, level, bass, treble)
  }

  *kr { | in1, level(1.0), bass(0.0), treble(0.0) |
      ^this.multiNew('control', in1, level, bass, treble)
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

  name { ^"FaustCabinetImpulseFormer" }


  info { ^"Generated with Faust" }
}

