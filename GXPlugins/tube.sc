FaustTube : UGen
{
  *ar { | in1, fuzzy(1.0) |
      ^this.multiNew('audio', in1, fuzzy)
  }

  *kr { | in1, fuzzy(1.0) |
      ^this.multiNew('control', in1, fuzzy)
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

  name { ^"FaustTube" }


  info { ^"Generated with Faust" }
}

