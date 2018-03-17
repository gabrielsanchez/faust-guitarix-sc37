FaustBassbooster : UGen
{
  *ar { | in1, bassbooster_level(10.0) |
      ^this.multiNew('audio', in1, bassbooster_level)
  }

  *kr { | in1, bassbooster_level(10.0) |
      ^this.multiNew('control', in1, bassbooster_level)
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

  name { ^"FaustBassbooster" }


  info { ^"Generated with Faust" }
}

