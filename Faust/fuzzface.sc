FaustFuzzFace : UGen
{
  *ar { | in1, fuzz(0.5), level(0.5) |
      ^this.multiNew('audio', in1, fuzz, level)
  }

  *kr { | in1, fuzz(0.5), level(0.5) |
      ^this.multiNew('control', in1, fuzz, level)
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

  name { ^"FaustFuzzFace" }


  info { ^"Generated with Faust" }
}

