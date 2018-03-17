FaustTrebleBoost : UGen
{
  *ar { | in1, level(0.5) |
      ^this.multiNew('audio', in1, level)
  }

  *kr { | in1, level(0.5) |
      ^this.multiNew('control', in1, level)
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

  name { ^"FaustTrebleBoost" }


  info { ^"Generated with Faust" }
}

