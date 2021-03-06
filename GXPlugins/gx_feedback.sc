FaustFeedback : UGen
{
  *ar { | in1, feedback(0.0), wet_dry(100.0) |
      ^this.multiNew('audio', in1, feedback, wet_dry)
  }

  *kr { | in1, feedback(0.0), wet_dry(100.0) |
      ^this.multiNew('control', in1, feedback, wet_dry)
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

  name { ^"FaustFeedback" }


  info { ^"Generated with Faust" }
}

