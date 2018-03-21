FaustPreamp : UGen
{
  *ar { | in1, atan(1.0) |
      ^this.multiNew('audio', in1, atan)
  }

  *kr { | in1, atan(1.0) |
      ^this.multiNew('control', in1, atan)
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

  name { ^"FaustPreamp" }


  info { ^"Generated with Faust" }
}

