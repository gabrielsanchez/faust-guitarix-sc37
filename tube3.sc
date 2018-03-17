FaustTube3 : UGen
{
  *ar { | in1, dist(0.0), g(1.0), q(0.4) |
      ^this.multiNew('audio', in1, dist, g, q)
  }

  *kr { | in1, dist(0.0), g(1.0), q(0.4) |
      ^this.multiNew('control', in1, dist, g, q)
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

  name { ^"FaustTube3" }


  info { ^"Generated with Faust" }
}

