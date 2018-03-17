FaustAmp : UGen
{
  *ar { | in1, in_level(0.0) |
      ^this.multiNew('audio', in1, in_level)
  }

  *kr { | in1, in_level(0.0) |
      ^this.multiNew('control', in1, in_level)
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

  name { ^"FaustAmp" }


  info { ^"Generated with Faust" }
}

