FaustVolume : UGen
{
  *ar { | in1, gain(0.0) |
      ^this.multiNew('audio', in1, gain)
  }

  *kr { | in1, gain(0.0) |
      ^this.multiNew('control', in1, gain)
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

  name { ^"FaustVolume" }


  info { ^"Generated with Faust" }
}

