FaustResoTube : UGen
{
  *ar { | in1, fuzzy(1.0), resonanz(0.5), vibrato(1.0) |
      ^this.multiNew('audio', in1, fuzzy, resonanz, vibrato)
  }

  *kr { | in1, fuzzy(1.0), resonanz(0.5), vibrato(1.0) |
      ^this.multiNew('control', in1, fuzzy, resonanz, vibrato)
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

  name { ^"FaustResoTube" }


  info { ^"Generated with Faust" }
}

