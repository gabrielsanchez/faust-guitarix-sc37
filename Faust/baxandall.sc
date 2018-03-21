FaustBaxandall : UGen
{
  *ar { | in1, ba(0.5), tr(0.5) |
      ^this.multiNew('audio', in1, ba, tr)
  }

  *kr { | in1, ba(0.5), tr(0.5) |
      ^this.multiNew('control', in1, ba, tr)
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

  name { ^"FaustBaxandall" }


  info { ^"Generated with Faust" }
}

