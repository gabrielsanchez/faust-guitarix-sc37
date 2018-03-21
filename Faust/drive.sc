FaustDrive : UGen
{
  *ar { | in1, value(1.0) |
      ^this.multiNew('audio', in1, value)
  }

  *kr { | in1, value(1.0) |
      ^this.multiNew('control', in1, value)
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

  name { ^"FaustDrive" }


  info { ^"Generated with Faust" }
}

