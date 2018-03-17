FaustGxdistortion : UGen
{
  *ar { | in1, in2 |
      ^this.multiNew('audio', in1, in2)
  }

  *kr { | in1, in2 |
      ^this.multiNew('control', in1, in2)
  } 

  checkInputs {
    if (rate == 'audio', {
      2.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustGxdistortion" }


  info { ^"Generated with Faust" }
}

