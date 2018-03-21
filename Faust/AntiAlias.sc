FaustAntiAlias : UGen
{
  *ar { | in1, feedback(0.3) |
      ^this.multiNew('audio', in1, feedback)
  }

  *kr { | in1, feedback(0.3) |
      ^this.multiNew('control', in1, feedback)
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

  name { ^"FaustAntiAlias" }


  info { ^"Generated with Faust" }
}

